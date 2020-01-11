compile:
	javac *.java

run:
	java assignment3 5 DH test/inputdh1.txt > test/outputdh1.txt
	java assignment3 5 SCBST test/inputsc1.txt > test/outputsc1.txt
	java assignment3 5 SCBST test/inputsc2.txt > test/outputsc2.txt

clean:
	rm *.class


