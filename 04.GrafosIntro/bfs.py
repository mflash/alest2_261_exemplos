import sys
from queue import Queue
from graph import Graph

class BFS:

    def __init__(self, g, s):
        self.g = g
        self.start = s

        self.marked = {}
        self.edgeTo = {}
        self.distTo = {}

        self.bfs(s)

    def bfs(self, v):
        fila = Queue()
        fila.put(v)
        while fila.qsize() > 0:
            for w in g.getAdj(v):
                if w not in self.marked:
                    pass

    def hasPathTo(self, v):
        return v in self.marked
    
    def pathTo(self, v):
        path = []
        if not self.hasPathTo(v):
            return path
        while v != self.start:
            path.insert(0,v)
            v = self.edgeTo[v]
        path.insert(0,self.start)
        return path

if __name__ == "__main__":

    g = Graph("exemplos/tinyG.txt")
    bfs = BFS(g, "0")

    for v in g.getVerts():
        print(f"{v}: ", end="")
        if bfs.hasPathTo(v):
            for w in bfs.pathTo(v):
                print(f"{w} ", end="")
            print()
        print()
    print()
