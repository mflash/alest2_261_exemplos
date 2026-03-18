# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -O2

# Target executable
TARGET = appheap

# Source files
SOURCES = appheap.cpp

# Build target
all: $(TARGET)

$(TARGET): $(SOURCES) $(INCLUDES)
	$(CXX) $(CXXFLAGS) -o $(TARGET) $(SOURCES)

# Clean up build files
clean:
	rm -f $(TARGET)

# Phony targets
.PHONY: all clean
