import time
n ,bucket_size,incoming,outgoing=map(int,input("enter the no. of inputs,size of bucket, incoming rate,outgoingrate").split());
store=0

while(n!=0):
    print("incoming size is ",incoming)
    if (incoming<=(bucket_size-store)):
        store+=incoming
        print("bucket buffer size is",store,"out of",bucket_size)
    else:
        print("packet loss",(incoming-(bucket_size-store)))
        store=bucket_size
        print("bucket buffer size is",store,"out of ",bucket_size)
    store-=outgoing
    print("after outgoing",store,"packets left out of ",bucket_size,"in buffer")
    print()
    n-=1
    time.sleep(1)

    # give initial inputs as 3 300 200 50 to understand the whole scenario












