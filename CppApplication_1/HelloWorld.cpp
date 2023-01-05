/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: 44869
 *
 * Created on March 26, 2020, 9:29 AM
 */

#include <iostream>
using namespace std;

const int apple = 3, orange = 4;
#define LENGTH 10   
#define WIDTH  5
#define NEWLINE '\n'

int main()
{
   short int i;           // 有符号短整数
   short unsigned int j;  // 无符号短整数
 
   i = 50000;
 
   j = i;
   cout << i << " " << j;
 
   return 0;
}