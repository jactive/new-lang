#include <cstdio>

void ref(int& i) {
   i++;
}

void pointer(int* i) {
   (*i)++;
}

int main(void) {
   /*! const */ int i = 10;
   ref(i);
   printf("after calling ref(i), i becomes %d\n", i);
   pointer(&i);
   printf("after calling pointer(&i), i becomes %d\n", i);
}
