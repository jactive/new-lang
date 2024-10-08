#include <string>
#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

int main() {
  ifstream in("./11.read_in_splitted_by_spaces.cpp");

  string word;
  vector<string> words;
  while (in >> word) {
    cout << word << endl;
    words.push_back(word);
  }

  for (int i=0; i< 31; i++) {
    cout << "- ";
  }
  cout << endl;

  for (int i=0; i < words.size(); i++) {
    cout << words[i] << endl;
  }
}
