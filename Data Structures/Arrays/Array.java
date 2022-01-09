
public class Array<T>{
    private Object array[];
    private int size;
    private int index;

    public Array(int size){
        this.size = size;
        this.index = -1;
        this.array = new Object[size];
    }

    // Get and Set
    @SuppressWarnings("unchecked")
    public T get(int pos){
        if(index < pos || pos < 0){
            return null;
        }
        else {
            return (T) array[pos];
        }
    }

    public int set(int pos, T element){
        if(index < pos || pos < 0){
            return -1;
        }
        else {
            array[pos] = element;
            return pos; 
        }
    }

    // Print operations
    public void print(){
        System.out.println("[");
        for (int i = 0; i <= index; ++i){
            System.out.println(array[i] + " ");
        }
        if (this.index == -1){
            System.out.println(" ");
        }
        System.out.println("\b]");
    }

    @Override
    public String toString(){
        String result = "Array(" + this.size + ")[";
        for (int i = 0; i <= index; ++i){
            result += "\"" + array[i] + "\",";
        }
        if (this.index == -1){
            result += " ";
        }
        result += "\b]";
        return result;
    }

    // Insert Operations

    public int insert(int pos, T element){
        if (index == size - 1 || pos < 0 || pos >= size){
            return -1;
        }
        for (int i = index; i >= pos; --i){
            array[i + 1] = array[i];
        }
        ++index;
        array[pos] = element;
        return pos;
    }

    public int append(T element){
        return insert(index + 1, element);
    }

    public int prepend(T element){
        return insert(0, element);
    }

    // Delete operations

    public int remove(int pos){
        
        if (pos < 0 || pos > index){
            return -1;
        }
        for (int i = pos; i < index; ++i){
            array[i] = array[i + 1];
        }
        --index;
        return pos;
    }

    @SuppressWarnings("unchecked")
    public T deleteFromStart(){
        T obj = (T) array[0];
        remove(0);
        return obj;
    }

    @SuppressWarnings("unchecked")
    public T deleteFromEnd(){
        T obj = (T) array[index];
        remove(index);
        return obj;
    }

    @SuppressWarnings("unchecked")
    public int deleteFirst(T element){
        for(int i = 0; i < index; ++i){
            if ((T) array[i] == element){
                return remove(i);
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public int deleteLast(T element){
        for(int i = index; i >= 0; --i){
            if ((T) array[i] == element){
                return remove(i);
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public int deleteAll(T element){
        int count = 0, i = 0;
        while(i <= index){
            if ((T) array[i] == element){
                remove(i);
                ++count;
            }
            else{
                ++i;
            }
        }
        return count;
    }

    // Other Operations

    public int resize(int size){
        if (size < index){
            return -1;
        }
        this.size = size;
        Object[] newArr = new Object[size];
        for(int i = 0; i <= index; ++i){
            newArr[i] = array[i];
        }
        this.array = newArr;
        return size;
    }

    public int getSize(){
        return this.size;
    }

    public int getLength(){
        return this.index + 1;
    }
    
    // Main
    public static void main(String[] args){
        Array<String> array = new Array<String>(3);
        array.append("Hello");
        array.append(" ");
        array.append("World");
        System.out.println(array);
    }
}
