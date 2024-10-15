#include <climits>
#include <cstdio>

using namespace std;

int main(void) {
	printf("sizeof(char), %ld byte.\n", sizeof(char));
   printf("CHAR_BIT, %d bits.\n", CHAR_BIT);
   // exponential notation, 6 times 10 to the minus fourth power.
   double fudge_ripple = 6e-4;
   printf ("6e-4, %f\n.", fudge_ripple);
}


