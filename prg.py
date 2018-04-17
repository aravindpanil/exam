import fileinput
import re
import time

with open("cprogram.c","r") as f:
	cvar = f.read().splitlines()
with open("cppprogram.cpp","r") as f:
	cppvar = f.read().splitlines()
with open("javaprogram.java","r") as f:
	javavar = f.read().splitlines()
final=[cvar,cppvar,javavar]
typec=[]
typej = []
typecpp = []
flag = -1

def removeemptylines():
	for item in final:
		for element in item:
			if element == "":
				item.remove(element)

def initialization():
	if(("#include<stdio.h>" in cvar)&("#include<iostream>" in cppvar)):
		cvalidation()
	else:
		exitfromprogram()

	if(re.match("import",javavar[0])):
		javalidation()
	else:
		exitfromprogram()	

	if(re.match("class",javavar[1])):
		javavar.pop(1)
	else:
		exitfromprogram()

	if("std" in cppvar[1]):
		cppvar.pop(1)
	else:
		exitfromprogram()

	if(("main" in cvar[1])&("main" in cppvar[1])&("main" in javavar[1])):
		mainvalidation()
	else:
		exitfromprogram()

def cvalidation():
	print("C program and CPP header files validated\nC program header file is #include<stdio.h> and CPP header file is #include<iostream>")

def javalidation():
	print("Java Header validated. Java header is "+javavar[0])	

def mainvalidation():
	print("Main found in all program files")

def exitfromprogram():
	print("Code is wrong. Please check it and retype it. Exiting in 5 seconds\n")
	time.sleep(5)
	exit()

def getindex():
	cbstart = []
	for program in final:
		for element in program:	
			if("{" in element):
				cbstart.append(program.index(element))

	cbstart = [x+1 for x in cbstart]
	return cbstart


def regexdeclare():
	pat = r'\s*(?P<type>float|int|void|double) (?P<var>(\w+,)*(\w+))+;'
	for program in final:	
		for line in program:
			res = re.match(pat,line)
			if(res):
				if(program == cvar):
					listitem = [res.group('type'),res.group('var')]
					typec.append(listitem)
				if(program == cppvar):
					listitem = [res.group('type'),res.group('var')]
					typecpp.append(listitem)
				if(program == javavar):
					listitem = [res.group('type'),res.group('var')]
					typej.append(listitem)
				
	typelist = [typec,typecpp,typej]
	for program in typelist:
		program.sort()
	clen = len(typec)
	cpplen = len(typecpp)
	jlen = len(typej)

	if(clen == cpplen == jlen):
		print("\nAll programs have same variable declarations. The memory allocation is same.")
	else:
		if(clen == cpplen):
			print("\nJava program has different memory allocation. C and CPP have same memory structure")
		elif(clen == jlen):
			print("\nCPP program has different memory allocation. C and Java have same memory structure")
		elif(cpplen == jlen):
			print("\nC program has different memory allocation. CPP and Java have same memory structure")
		else:
			flag = 4
			print("\nAll three programs have different memory structures")

	print("The memory structure is as follows\n")
	print("C Memory Structure")
	for item in typec:
		print(item[0] + "-" + item[1] + "")
	print("CPP Memory Structure")
	for item in typecpp:
		print(item[0] + "-" + item[1]+ "")
	print("Java Memory Structure")
	for item in typej:
		print(item[0] + "-" + item[1]+ "")
	print("\n")
def functionsig():
	print("The Functions in each program and their line numbers are\n")
	for item in ["cprogram.c","cppprogram.cpp","javaprogram.java"]:
		f=open(item)
		s=f.read()
		k=s
		pat=re.compile("(int|double|void|float) [a-z]+\((((int|double|void|float) \s*[a-z]+\s*,)*\s*((int|double|void|float) \s*[a-z]+\s*))?\)")
		orig=0
		i=0
		nol=0
		while(pat.search(s)):
			m=pat.search(s)
			print("Line number - "+(str)(s[0:m.start()].count("\n")+1+nol))
			nol=nol+s[m.start():m.end()].count("\n")+s[0:m.start()].count("\n")
			print(item+ " - "+m.group())
			i=m.end()
			s=s[i:]

removeemptylines()
print("HEADER FILE INITIALIZATION\n")
initialization()
beginindex=getindex()
regexdeclare()
functionsig()

