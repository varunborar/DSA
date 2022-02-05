#include <iostream>

using namespace std;

template <typename T>
class LinkedList
{
    template <typename T>
    struct Node
    {
        T data;
        Node *next;

        Node()
        {
            data = NULL;
            next = NULL;
        }
        Node(T obj)
        {
            data = obj;
            next = NULL;
        }
    };

    Node<T> *head;
    int size;

public:
    LinkedList()
    {
        head = NULL;
        size = 0;
    }

    // Search Operations
    int find(T obj)
    {
        Node<T> *temp = head;
        int index = 0;

        while (temp)
        {
            if (temp->data == obj)
            {
                break;
            }
            temp = temp->next;
            ++index;
        }

        if (temp)
        {
            return index;
        }
        return -1;
    }

    // Insert Operations
    int insert(T obj, int index)
    {
        ++size;
        if (index >= size)
        {
            return -1;
        }
        else
        {
            Node<T> *newNode = new Node<T>(obj);
            Node<T> *temp = head;
            if (!head || index == 0)
            {
                newNode->next = head;
                head = newNode;
            }
            else
            {
                int shift = index - 1;
                while (shift--)
                {
                    temp = temp->next;
                }
                newNode->next = temp->next;
                temp->next = newNode;
            }
        }
        return 0;
    }

    int prepend(T obj)
    {
        return insert(obj, 0);
    }

    int append(T obj)
    {
        return insert(obj, size);
    }

    // Delete Operation
    int remove(int pos)
    {
        Node<T> *del = head;
        if (!head || pos >= size)
        {
            return -1;
        }
        else if (pos == 0)
        {
            head = head->next;
        }
        else
        {
            Node<T> *temp = head;
            int shift = pos - 1;
            while(shift--){
                temp = temp->next;
            }
            del = temp->next;
            temp->next = temp->next->next;
        }
        --size;
        delete del;
        return 0;
    }

    int findAndRemove(T obj){
        int index = find(obj);
        if(index == -1){
            return -1;
        }
        else{
            remove(index);
        }
        return 0;
    }

    // Print operation
    void print()
    {
        if (!head)
        {
            cout << "List is empty";
        }
        else
        {
            Node<T> *temp = head;
            while (temp->next)
            {
                cout << temp->data << "->";
                temp = temp->next;
            }
            cout << temp->data;
        }
    }

    // Other operations
    int getSize(){
        return size;
    }
};

int main()
{
    LinkedList<int> ll;
    ll.insert(1, 0);
    ll.insert(2, 1);
    ll.insert(3, 2);
    ll.insert(6, 2);
    ll.append(4);
    ll.prepend(0);
    ll.print();
    cout << endl;
    return 0;
}