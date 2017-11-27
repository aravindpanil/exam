#include "ns3/core-module.h"
#include "ns3/network-module.h"
#include "ns3/internet-module.h"
#include "ns3/point-to-point-module.h"
#include "ns3/applications-module.h"
#include "ns3/traffic-control-module.h"
#include "ns3/flow-monitor-module.h"
#include "ns3/netanim-module.h"


// Network topology
//
//       10.1.1.0       10.1.2.0
// n0 -------------- n1..........n2
//    point-to-point
//


using namespace ns3;

NS_LOG_COMPONENT_DEFINE ("3-node-Example");


int main (int argc, char *argv[])
{
  double simulationTime = 10; //seconds
  std::string transportProt = "Udp";
  std::string socketType= "ns3::UdpSocketFactory";;

  CommandLine cmd;
  cmd.Parse (argc, argv);

    NodeContainer nodes;
    nodes.Create (3);
   
   
    PointToPointHelper p2p1;
    p2p1.SetDeviceAttribute ("DataRate", StringValue ("5Mbps"));
    p2p1.SetChannelAttribute ("Delay", StringValue ("1ms"));

    NetDeviceContainer devices;
    devices = p2p1.Install (nodes.Get (0), nodes.Get (1));

    InternetStackHelper stack;
    stack.Install (nodes);

   Ipv4AddressHelper address;
   address.SetBase ("10.1.1.0", "255.255.255.0");

    Ipv4InterfaceContainer interfaces = address.Assign (devices);
   
    
    devices = p2p1.Install (nodes.Get (1), nodes.Get (2));
    address.SetBase ("10.1.2.0", "255.255.255.0");
    interfaces = address.Assign (devices);
   
    Ipv4GlobalRoutingHelper::PopulateRoutingTables ();

//Configuring application on nodes
//Flow n0....n1
  uint16_t port = 7;

   //1. Install receiver (for packetsink) on node 2
  Address localAddress1 (InetSocketAddress (Ipv4Address::GetAny (), port));
  PacketSinkHelper packetSinkHelper1 (socketType, localAddress1);
  ApplicationContainer sinkApp1 = packetSinkHelper1.Install (nodes.Get (2));
  sinkApp1.Start (Seconds (0.0));
  sinkApp1.Stop (Seconds (simulationTime + 0.1));


  uint32_t payloadSize = 1448;
  OnOffHelper onoff (socketType, Ipv4Address::GetAny ());

  onoff.SetAttribute ("OnTime",  StringValue ("ns3::ConstantRandomVariable[Constant=1]"));

  onoff.SetAttribute ("OffTime", StringValue ("ns3::ConstantRandomVariable[Constant=0]"));

  onoff.SetAttribute ("PacketSize", UintegerValue (payloadSize));

  onoff.SetAttribute ("DataRate", StringValue ("50Mbps")); //bit/s
  
  //2. Install sender app on node 0
  ApplicationContainer apps;
  AddressValue remoteAddress (InetSocketAddress (interfaces.GetAddress (1), port));
  onoff.SetAttribute ("Remote", remoteAddress);
  apps.Add (onoff.Install (nodes.Get (0)));
  apps.Start (Seconds (1.0));
  apps.Stop (Seconds (simulationTime + 0.1));

//Enable Tracing using flowmonitor
  FlowMonitorHelper flowmon;
  Ptr<FlowMonitor> monitor = flowmon.InstallAll();

//Set when to stop simulator
  Simulator::Stop (Seconds (simulationTime + 5));

//Add visualization using Netanim
  AnimationInterface anim ("ex1.xml"); 
  AnimationInterface::SetConstantPosition(nodes.Get(0), 1.0, 2.0);
  AnimationInterface::SetConstantPosition(nodes.Get(1), 2.0, 2.0);
  AnimationInterface::SetConstantPosition(nodes.Get(2), 3.0, 2.0);
  anim.EnablePacketMetadata (); // Optional

//Run the simulator
  Simulator::Run ();

 // Print per flow statistics
  monitor->CheckForLostPackets ();
  Ptr<Ipv4FlowClassifier> classifier = DynamicCast<Ipv4FlowClassifier> (flowmon.GetClassifier ());
  std::map<FlowId, FlowMonitor::FlowStats> stats = monitor->GetFlowStats ();

  for (std::map<FlowId, FlowMonitor::FlowStats>::const_iterator iter = stats.begin (); iter != stats.end (); ++iter)
    {
  Ipv4FlowClassifier::FiveTuple t = classifier->FindFlow (iter->first);
      NS_LOG_UNCOND("Flow ID: " << iter->first << " Src Addr " << t.sourceAddress << " Dst Addr " << t.destinationAddress);
      NS_LOG_UNCOND("Tx Packets = " << iter->second.txPackets);
      NS_LOG_UNCOND("Rx Packets = " << iter->second.rxPackets);
      NS_LOG_UNCOND("lostPackets Packets = " << iter->second.lostPackets);
      NS_LOG_UNCOND("Throughput: " << iter->second.rxBytes * 8.0 / (iter->second.timeLastRxPacket.GetSeconds()-iter->second.timeFirstTxPacket.GetSeconds()) / 1024  << " Kbps");
    }

  Simulator::Destroy ();

  
  return 0;
}



