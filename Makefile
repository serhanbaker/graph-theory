JFLAGS = -g
JC = javac
JVM = java
FILE =
.SUFFIXES: .java .class
.java.class:
	        $(JC) $(JFLAGS) $*.java
CLASSES = \
        Test.java \
        Graph.java \

MAIN = Test

default: classes
				$(JVM) $(MAIN)

classes: $(CLASSES:.java=.class)

clean:
	        $(RM) *.class
