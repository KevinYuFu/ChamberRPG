# Note: I stole this from lectures (y)

# Make file for java application
NAME = "ChamberRPG"

all:
	@echo "Compiling..."
	#javac -cp vecmath-1.5.1.jar *.java
	javac *.java

run: all
	@echo "Running..."
	#java -cp "vecmath-1.5.1.jar:." $(NAME)
	java $(NAME)

clean:
	rm -rf *.class
