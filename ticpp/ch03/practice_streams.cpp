#include <string>
#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

int main(void) {
   ifstream in("/etc/passwd");
   ofstream of("/tmp/passwd");

   string line;
   vector<string> lines;
   while (in >> line) {
      lines.push_back(line);
   }

   cout << "line number, " << lines.size() << endl;
   for (int i=0; i < lines.size(); i++) {
      cout << "line " << i << ": " << lines[i] << endl;
   }

   cout << "first line of /etc/group, ";
   ifstream in2("/etc/group");
   while (getline(in2, line)) {
      cout << line << endl;
      break;
   }
}
