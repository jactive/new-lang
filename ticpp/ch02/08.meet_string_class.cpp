#include <string>
#include <iostream>

using namespace std;

int main() {
   string s1, s2; // empty strings are defined
   string s3 = "Hello, world."; // initialized
   string s4("I feel"); // also initialized
   s2 = "Today"; // assigned with a string
   s1 = s3 + " " + s4; // combining strings
   s1 += " good "; // appending to a string
   cout << s1 + s2 + "!" << endl;
}
