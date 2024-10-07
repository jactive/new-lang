extern int i; // Declaration without definition
extern float f(float); // Declaration without definition

float b; // Declaration & definition
float f(float a) { // Definition
  return a + 1.0;
}

int i; // Definition. note.md: the declared variable can be defined in the same file
int h(int x) { // Declaration & definition
  return x + 1;
}

int main() {
  b = 1.0;
  i = 2;

  f(b);
  h(i);
}
