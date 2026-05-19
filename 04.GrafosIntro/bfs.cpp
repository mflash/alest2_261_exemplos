#include "bfs.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <queue>

using namespace std;

BreadthFirstSearch::BreadthFirstSearch(Graph &g, string s)
{
	this->s = s;
	bfs(g, s);
}

void BreadthFirstSearch::bfs(Graph &g, string v)
{
	queue<string> fila;
	while (!fila.empty())
	{
		// ... obtém x a partir da fila
		for (auto const &w : g.getAdj(x))
		{
			if (marked.find(w) == marked.end())
			{
				//
			}
		}
	}
}

bool BreadthFirstSearch::hasPathTo(string s)
{
	return marked.find(s) != marked.end();
}

vector<string> BreadthFirstSearch::pathTo(string v)
{
	vector<string> path;
	while (v != s)
	{
		path.insert(path.begin(), v);
		v = edgeTo[v];
	}
	path.insert(path.begin(), s);
	return path;
}
