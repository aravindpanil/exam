import re
f=open("cprogram.c");
s=f.read()
k=s
pat=re.compile("(int|double|void|float) [a-z]+\((((int|double|void|float) \s*[a-z]+\s*,)*\s*((int|double|void|float) \s*[a-z]+\s*))?\)");
orig=0;
i=0
nol=0;
while(pat.search(s)):
    
    m=pat.search(s)
    

    print(s[0:m.start()].count("\n")+1+nol);
    nol=nol+s[m.start():m.end()].count("\n")+s[0:m.start()].count("\n");
    
    print(m.group())
    i=m.end();
    s=s[i:]
    
#(([(int)|(double)|(void)|(float)] [a-z]+,)* ([(int)|(double)|(void)|(float)] [a-z]+))?
#"(int|double|void|float) [a-z]+\(\){"