#include <iostream>
using namespace std;

class Calculator
{
  public:
    int Calculate(int, int, char);
};

int main()
{
    int x, y, res;
    char oper;
    cout << "Enter 2 numbers and operation" << endl;
    cin >> x >> y >> oper;
    Calculator cal;
    res = cal.Calculate(x, y, oper);

    cout << "Result is: " << res << endl;

    cin.ignore();
    cin.get();
    return 0;
}

int Calculator::Calculate(int x, int y, char oper)
{
    switch (oper)
    {
    case '+':
        return x + y;
    case '-':
        return x - y;
    case '*':
        return x * y;
    case '/':
        if (y != 0)
            return x / y;
    }
}