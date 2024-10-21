#include <iostream>

using namespace std;

int main(void) {
   cout << "Enter A or B, or others to exit" << endl;

   while (char entered = cin.get()) {
      switch (entered) {
         case 'a':
         case 'A':
            cout << "apple" << endl;
            break;
         case 'b':
         case 'B':
            cout << "berry" << endl;
            break;
         case 'c':
         case 'C':
            cout << "cashew" << endl;
            break;
         case '\n':
            // ignore line break
            break;
         defalut: // the typo cause dead loop, because of no default
         // default:
            cout << "bye - " << entered << endl;
            return 0;
      }
   }
}
