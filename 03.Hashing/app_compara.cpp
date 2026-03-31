#include <iostream>
#include <fstream>
#include <algorithm>
#include "linearprobing_hashtable.h"
#include "separatechaining_hashtable.h"

using namespace std;

int main()
{
    ifstream file("DomCasmurro_utf8.txt");
    string pal;

    LinearProbingHashTable<string, int> dic;
    // SeparateChainingHashTable<string, int> dic;
    if (file.is_open()) {
        while (file >> pal) {
            transform(pal.begin(), pal.end(), pal.begin(),
                [](unsigned char c) { return std::tolower(c); });
            // cout << pal << endl;
            if (!dic.contains(pal))
                dic.insert(pal, 1);
            else
                dic.insert(pal, dic.get(pal) + 1);
        }
        file.close();
        cout << "Total de palavras: " << dic.size() << endl;
    }
    else {
        cerr << "Impossível abrir o arquivo!" << endl;
    }
    return 0;
}