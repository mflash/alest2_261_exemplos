#include <vector>
#include <map>
#include <set>
#include <string>
#include "graph.h"

#ifndef ORDEM_TOPO_H
#define ORDEM_TOPO_H

class OrdTopologica
{

public:
	OrdTopologica(Graph &g);

	std::vector<std::string> getOrdemTopo();

private:
	std::set<std::string> marked;
	std::vector<std::string> ordemTopo;
	void dfs(Graph &g, std::string v);
};

#endif
