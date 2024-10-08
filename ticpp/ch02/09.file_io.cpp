#include <string>
#include <fstream>
#include <iostream>

using namespace std;

int main() {
   ifstream in("/etc/passwd");
   ofstream of("/tmp/passwd");

   string line;
   while (getline(in, line)) {
      of   << line << endl;
      cout << line << endl;
   }
}
