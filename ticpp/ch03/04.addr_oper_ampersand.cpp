#include <cstdio>
#include <iostream>

using namespace std;

// contiguously up. queuing
int external_var_1, external_var_2;

void f(int pet) {
  cout << "pet id number: " << pet << endl;
}

int main() {
  // contiguously down. stacking
  int stack_var_1, stack_var_2;
  printf("f(): %p\n", &f);
  printf("main(): %p\n", &main);
  printf("external_var_1: %p, sizeof %lu\n", &external_var_1, sizeof(external_var_1));
  printf("external_var_2: %p, sizeof %lu\n", &external_var_2, sizeof(external_var_2));

  printf("stack_var_1: %p, sizeof %lu\n", &stack_var_1, sizeof(stack_var_1));
  printf("stack_var_2: %p, sizeof %lu\n", &stack_var_2, sizeof(stack_var_2));
}
