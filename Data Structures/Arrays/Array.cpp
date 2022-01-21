#include <iostream>

using namespace std;

template <class T>
class Array
{
    T *array;
    int index;
    int size;

public:
    Array(unsigned int size)
    {
        this->size = size;
        this->index = -1;
        array = new T[size];
    }

    ~Array()
    {
        delete[] array;
    }

    // Print operation

    void print()
    {
        cout << "[";
        for (int i = 0; i <= index; i++)
        {
            cout << array[i] << " ";
        }
        cout << "\b]\n";
    }

    // get and set operations

    T get(int pos)
    {
        if (index < pos)
        {
            return NULL;
        }
        return array[pos];
    }

    int set(int pos, T element)
    {
        if (pos > size || pos < 0)
        {
            return -1;
        }
        array[pos] = element;
        return 0;
    }

    // Insert Operations

    int append(T element)
    {

        if (index >= size)
        {
            return -1;
        }
        else
        {
            array[++index] = element;
        }
        return 0;
    }

    int prepend(T element)
    {

        if (index == size - 1)
        {
            return -1;
        }
        else
        {
            for (int i = index; i >= 0; --i)
            {
                array[i + 1] = array[i];
            }
            index++;
            array[0] = element;
        }
        return 0;
    }

    int insert(int pos, int element)
    {

        if (index == size - 1)
        {
            return -1;
        }
        else
        {
            for (int i = index; i >= pos; --i)
            {
                array[i + 1] = array[i];
            }
            ++index;
            array[pos] = element;
        }
        return 0;
    }

    // Delete Operations

    T remove(int pos)
    {
        if (index < pos || pos < 0)
        {
            return -1;
        }
        T deleted = array[pos];
        for (int i = pos; i < index; i++)
        {
            array[i] = array[i + 1];
        }
        --index;
        return deleted;
    }

    T deleteFromStart()
    {
        if (index == -1)
        {
            return -1;
        }
        return remove(0);
    }

    int deleteFirst(T element)
    {
        if (index == -1)
        {
            return -1;
        }

        for (int i = 0; i <= index; i++)
        {
            if (array[i] == element)
            {
                remove(i);
                return i;
            }
        }
        return -1;
    }

    int deleteLast(T element)
    {
        if (index == -1)
        {
            return -1;
        }

        int lastIndex = -1;
        for (int i = 0; i <= index; i++)
        {
            if (array[i] == element)
            {
                lastIndex = i;
            }
        }
        if (lastIndex)
        {
            remove(lastIndex);
            return lastIndex;
        }
        return -1;
    }

    int deleteAll(T element)
    {
        if (index == -1)
        {
            return -1;
        }
        int count = 0, i = 0;

        while (i <= index)
        {
            if (array[i] == element)
            {
                remove(i);
                ++count;
            }
            else
            {
                ++i;
            }
        }
        if (count)
        {
            return count;
        }
        return -1;
    }

    T deleteFromEnd()
    {
        if (index == -1)
        {
            return -1;
        }
        int elementToBeDeleted = array[index];
        remove(index);
        return elementToBeDeleted;
    }

    // Other Operations

    int resize(int size)
    {
        if (size < index)
        {
            return -1;
        }
        else
        {
            this->size = size;
            int *newArray = new int[size];
            for (int i = 0; i <= index; ++i)
            {
                newArray[i] = array[i];
            }
            delete[] array;
            array = newArray;
            return 0;
        }
    }

    bool isEmpty()
    {
        if (index == -1)
        {
            return true;
        }
        return false;
    }

    bool isFull()
    {
        if (index == size - 1)
        {
            return true;
        }
        return false;
    }

    int getSize()
    {
        return this->size;
    }

    int length(){
        return this->index + 1;
    }

    // Operator overloading;

    friend ostream &operator<<(ostream &output, const Array &array)
    {
        output << "Array(" << array.size << ")[";
        for (int i = 0; i <= array.index; i++)
        {
            output << "\"" << array.array[i] << "\",";
        }
        if(array.index == -1)
            output << "]";
        else
            output << "\b]";
        return output;
    }

    T &operator[](int index)
    {
        if (index >= size)
        {
            exit(0);
        }
        return array[index];
    }
};

int main()
{

    Array<string> array(4);
    array.append("Varun");
    array.append("is");
    array.append("a");
    array.append("good");
    cout << array;
    return 0;
}