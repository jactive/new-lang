#include <iostream>

using namespace std;

int main(void) {
   cout << "press A, B and C or else to exit" << endl;

   while (char entered = cin.get()) {
      cout << "enter " << entered << endl;
      switch(entered) {
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
         defalut:
            cout << "kk" << endl;
            return 0;
      }
   }
}
