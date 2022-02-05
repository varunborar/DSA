#include <iostream>

using namespace std;

template <typename T>
class DoublyLinkedList{

    template <typename T>
    struct Node{
        T data;
        Node *prev;
        Node *next;

        Node(){
            data = NULL;
            prev = NULL;
            next = NULL;
        }
    };
    
};