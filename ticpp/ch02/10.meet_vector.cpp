#include <vector>
#include <string>
#include <fstream>
#include <iostream>

using namespace std;

int main() {
  ifstream in("/etc/passwd");
  vector<string> lines;

  string line;
  while(getline(in, line)) {
    lines.push_back(line);
  }
  cout << "vector.size(), " << lines.size() << endl;

  for (int i=0; i < lines.size(); i++) {
    cout << "line " << i << ": " << lines[i] << endl;
  }
}
