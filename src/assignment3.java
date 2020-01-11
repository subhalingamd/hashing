import java.lang.Math;
import java.io.*;

public class assignment3{
  public static void main(String[] args) {
    try{
       BufferedReader f = new BufferedReader(new FileReader(args[2]));
       String row;
      if (args[1].equals("DH")){
        MyHashTableForDH<Pair<String,String>,Student> Table=new MyHashTableForDH<Pair<String,String>,Student>(Integer.parseInt(args[0]));

        while ((row = f.readLine()) != null) {
          String[] col=row.split(" ");

          if (col[0].equals("insert")){
            int pos=Table.insert(new Pair<String,String>(col[1],col[2]),new Student(col[1],col[2],col[3],col[4],col[5]));
            if (pos==-1){
              System.out.println("E");
            }
            else{
              System.out.println(pos);
            }
          }
          else if (col[0].equals("update")){
            int pos=Table.update(new Pair<String,String>(col[1],col[2]),new Student(col[1],col[2],col[3],col[4],col[5]));
            if (pos==-1)
              System.out.println("E");
            else
              System.out.println(pos);
          }
          else if (col[0].equals("delete")){
            int pos=Table.delete(new Pair<String,String>(col[1],col[2]));
            if (pos==-1)
              System.out.println("E");
            else
              System.out.println(pos);

          }
          else if (col[0].equals("contains")){
            boolean res=Table.contains(new Pair<String,String>(col[1],col[2]));
            if (res)
              System.out.println("T");
            else
              System.out.println("F");
          }
          else if (col[0].equals("get")){
            try{
              Student S=Table.get(new Pair<String,String>(col[1],col[2]));
              System.out.println(S.toString());
            }
            catch (NotFoundException e){
              System.out.println("E");
            }
          }
          else if (col[0].equals("address")){
            try{
              String A=Table.address(new Pair<String,String>(col[1],col[2]));
              System.out.println(A);
            }
            catch (NotFoundException e){
              System.out.println("E");
            }
          }
          else{
            System.out.println("E");
          }
        }
      }
        else if(args[1].equals("SCBST")){
          MyHashTableForSC<Pair<String,String>,Student> Table=new MyHashTableForSC<Pair<String,String>,Student>(Integer.parseInt(args[0]));

        while ((row = f.readLine()) != null) {
          String[] col=row.split(" ");

          if (col[0].equals("insert")){
            int pos=Table.insert(new Pair<String,String>(col[1],col[2]),new Student(col[1],col[2],col[3],col[4],col[5]));
            if (pos==-1){
              System.out.println("E");
            }
            else{
              System.out.println(pos);
            }
          }
          else if (col[0].equals("update")){
            int pos=Table.update(new Pair<String,String>(col[1],col[2]),new Student(col[1],col[2],col[3],col[4],col[5]));
            if (pos==-1)
              System.out.println("E");
            else
              System.out.println(pos);
          }
          else if (col[0].equals("delete")){
            int pos=Table.delete(new Pair<String,String>(col[1],col[2]));
            if (pos==-1)
              System.out.println("E");
            else
              System.out.println(pos);

          }
          else if (col[0].equals("contains")){
            boolean res=Table.contains(new Pair<String,String>(col[1],col[2]));
            if (res)
              System.out.println("T");
            else
              System.out.println("F");
          }
          else if (col[0].equals("get")){
            try{
              Student S=Table.get(new Pair<String,String>(col[1],col[2]));
              System.out.println(S.toString());
            }
            catch (NotFoundException e){
              System.out.println("E");
            }
          }
          else if (col[0].equals("address")){
            try{
              String A=Table.address(new Pair<String,String>(col[1],col[2]));
              System.out.println(A);
            }
            catch (NotFoundException e){
              System.out.println("E");
            }
          }
          else{
            System.out.println("E");
          }
        }
      }
      else{
        System.out.println("E");
      }

       
    }
  
    catch(Exception e){
       System.out.println(e.toString());
    }
  }
    
}

class Student implements Student_ { 
  private String FName,LName,Hostel,Department,Cgpa;

  public Student(String FName,String LName,String Hostel,String Department,String Cgpa){
    this.FName = FName;
    this.LName = LName;
    this.Hostel = Hostel;
    this.Department = Department;
    this.Cgpa = Cgpa;
  }

   public String fname(){
    return FName;
   }       
   public String lname(){
    return LName;
   }    
   public String hostel(){
    return Hostel;
   }
   public String department(){
    return Department;
   }
   public String cgpa(){
    return Cgpa;
   } 

   @Override
   public String toString(){
    return FName+" "+LName+" "+Hostel+" "+Department+" "+Cgpa;
   }
}



class Pair<T1,T2> implements Comparable<Pair<T1,T2>>{
  private T1 First;
  private T2 Second;

  public Pair(T1 First,T2 Second){
    this.First = First; 
    this.Second = Second; 
  }

  @Override
  public String toString(){
    return First.toString()+Second.toString();
  }

  @Override
  public int compareTo(Pair<T1,T2> P){
    return this.First.toString().compareTo(P.First.toString());
  }
}



class KeyAndObj<K,T>{
  private K Key;
  private T Obj;

  public KeyAndObj(K Key,T Obj){
    this.Key=Key;
    this.Obj=Obj;
  }

  public T getObj(){
    return Obj;
  }

  public K getKey(){
    return Key;
  }

}




class Hash{
   public static long djb2(String str, int hashtableSize) { 
       long hash = 5381; 
       for (int i = 0; i < str.length(); i++) { 
           hash = ((hash << 5) + hash) + str.charAt(i); 
       } 
       return Math.abs(hash) % hashtableSize; 
   }

   public static long sdbm(String str, int hashtableSize) { 
       long hash = 0; 
       for (int i = 0; i < str.length(); i++) { 
           hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
       } 
       return Math.abs(hash) % (hashtableSize - 1) + 1; 
   }

}


class MyHashTableForDH<K, T> implements MyHashTable_<K, T> { 
   private KeyAndObj<K,T> Arr[];
   private int capacity;

   @SuppressWarnings("unchecked")
   public MyHashTableForDH(int capacity){
      this.capacity=capacity;
      Arr= new KeyAndObj[this.capacity];
   }


   // Insert new object with given key 
   public int insert(K key, T obj){
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null){
            Arr[hash]=new KeyAndObj<K,T>(key,obj);
            return i;
         }
         else if (Arr[hash].getKey()==null){
            Arr[hash]=new KeyAndObj<K,T>(key,obj);
            return i;
         }
         if (Arr[hash].getKey().toString().equals(key.toString())){
          return -1;
         }
      }
      return -1;
   } 

 
   // Update object for given key 
   public int update(K key, T obj){
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null)
          return -1;
         if (Arr[hash].getKey()!=null){ 
          if (key.toString().equals(Arr[hash].getKey().toString())){
            Arr[hash]=new KeyAndObj<K,T>(key,obj);
            return i;
          }
         }
      }
      return -1;

   } 
 
   // Delete object for given key 
   public int delete(K key){
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null)
          return -1;
         if (Arr[hash].getKey()!=null){
           if (key.toString().equals(Arr[hash].getKey().toString())){
            Arr[hash]=new KeyAndObj<K,T>(null,null);
            return i;
         }
        }
      }
      return -1;
      
   }
 
   // Does an object with this key exist? 
   public boolean contains(K key){
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null)
          return false;
         if (Arr[hash].getKey()!=null){
          if (key.toString().equals(Arr[hash].getKey().toString())){
            return true;
          }
         }
      }
      return false;
   }
 
   // Return the object with given key 
   public T get(K key) throws NotFoundException{
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null)
          throw new NotFoundException();
         if (Arr[hash].getKey()!=null){    
          if (key.toString().equals(Arr[hash].getKey().toString())){
            return Arr[hash].getObj();
          }
         }
      }
      throw new NotFoundException();
   }
 
   // ”Address” of object with given key (explained below) 
   public String address(K key) throws NotFoundException{
      int i=0;
      while(i<capacity){
         int hash=((int)(Hash.djb2(key.toString(),capacity)+i*Hash.sdbm(key.toString(),capacity)))%capacity;
         i++;
         if (Arr[hash]==null)
          throw new NotFoundException();
         if (Arr[hash].getKey()!=null) {
          if (key.toString().equals(Arr[hash].getKey().toString())){
            return Long.toString(hash);
         }
       }
      }
      throw new NotFoundException();
   }
}


@SuppressWarnings("unchecked")
class MyHashTableForSC<K extends Comparable<K>, T> implements MyHashTable_<K, T> { 

  private class KeyAndObjNode<K,T>{
    KeyAndObj<K,T> data;
    KeyAndObjNode<K,T> left,right;

    public KeyAndObjNode(KeyAndObj<K,T> Obj){
      data=Obj;
      left=null;
      right=null;
    }
  }

   private KeyAndObjNode<K,T> Arr[]; //root starts here
   private int capacity;

   @SuppressWarnings("unchecked")
  public MyHashTableForSC(int capacity){
      this.capacity=capacity;
      Arr=new KeyAndObjNode[this.capacity];
   }


   // Insert new object with given key 
   public int insert(K key, T obj){
      int hash=(int)(Hash.djb2(key.toString(),capacity));
      int i=1;
      if (Arr[hash]==null){
        KeyAndObjNode<K,T> mainroot=new KeyAndObjNode<K,T>(new KeyAndObj<K,T>(key,obj));
        Arr[hash]=mainroot;
        return i;
      }
      KeyAndObjNode<K,T> root=Arr[hash],parent=null;
      while (root!=null){
        parent=root;
        if (key.toString().equals(root.data.getKey().toString())){
          return -1;
        }
        if (key.compareTo(root.data.getKey())<0)
          root=root.left;
        else
          root=root.right;
        i++;
      }
      //root=new KeyAndObjNode<K,T>(new KeyAndObj<K,T>(key,obj));
      if (key.compareTo(parent.data.getKey())<0) 
        parent.left=new KeyAndObjNode<K,T>(new KeyAndObj<K,T>(key,obj));
      else
        parent.right=new KeyAndObjNode<K,T>(new KeyAndObj<K,T>(key,obj));
      return i;
    }
 
   // Update object for given key 
   public int update(K key, T obj){
      int hash=(int)(Hash.djb2(key.toString(),capacity));
      if (Arr[hash]==null)
        return -1;
      KeyAndObjNode<K,T> root=Arr[hash],parent=null;
      if (Arr[hash].data.getKey().toString().equals(key.toString())){
        Arr[hash].data=new KeyAndObj<K,T>(key,obj);
        return 1;
      }
      int i=1;
      while (root!=null){
        if (key.toString().equals(root.data.getKey().toString())){
          if (key.compareTo(parent.data.getKey())<0) 
            parent.left.data=new KeyAndObj<K,T>(key,obj);
          else
            parent.right.data=new KeyAndObj<K,T>(key,obj);
          return i;
        }
        parent=root;
        if (key.compareTo(root.data.getKey())<0)
          root=root.left;
        else
          root=root.right; 
        i++;
      }
      return -1;
   }
 
   // Delete object for given key 
   public int delete(K key){
    int hash=(int)(Hash.djb2(key.toString(),capacity));
    if (Arr[hash]==null)
      return -1;
    boolean found=false;
    KeyAndObjNode<K,T> root=Arr[hash],parent=null;
    int i=1;
    while (root!=null){
      if (key.toString().equals(root.data.getKey().toString())){
        found=true;
        break;
      }
      parent=root;
      if (key.compareTo(root.data.getKey())<0)
        root=root.left;
      else
        root=root.right; 
      i++;
    }
    if (!found)
      return -1;

    if (parent==null){  //root element deleted
      if (root.left==null && root.right==null){
        Arr[hash]=null;
      }
      else if (root.left==null){
        Arr[hash]=Arr[hash].right;
        i++;

      }
      else if (root.right==null){
        Arr[hash]=Arr[hash].left;
        i++;
      }
      else{
        KeyAndObjNode<K,T> succ=root.right,succpar=root;
        i++;
        while (succ.left!=null){
          succpar=succ;
          succ=succ.left;
          i++;
        }
        KeyAndObj<K,T> succ_data=new KeyAndObj<K,T>(succ.data.getKey(),succ.data.getObj());
        if (succpar==root){
          if (succ.right!=null){
                    succpar.right=succ.right;
                    i++;
                  }
                  else{
                    succpar.right=null;
                  }
        }
        else if (succ.right!=null){
          succpar.left=succ.right;
          i++;
        }
        else{
          succpar.left=null;
        }
        Arr[hash].data=succ_data;

      }
    }
    else{

      if (root.left==null && root.right==null){
        if (key.compareTo(parent.data.getKey())<0) 
          parent.left=null;
        else
          parent.right=null;
      }
      else if (root.left==null){
        if (key.compareTo(parent.data.getKey())<0) 
          parent.left=root.right;
        else
          parent.right=root.right;
        i++;

      }
      else if (root.right==null){
        if (key.compareTo(parent.data.getKey())<0) 
          parent.left=root.left;
        else
          parent.right=root.left;
        i++;
      }
      else{
        KeyAndObjNode<K,T> succ=root.right,succpar=root;
        i++;
        while (succ.left!=null){
          succpar=succ;
          succ=succ.left;
          i++;
        }
        KeyAndObj<K,T> succ_data=new KeyAndObj<K,T>(succ.data.getKey(),succ.data.getObj());

        if (succpar==root){
          if (succ.right!=null){
                    succpar.right=succ.right;
                    i++;
                  }
                  else{
                    succpar.right=null;
                  }
        }
        else if (succ.right!=null){
          succpar.left=succ.right;
          i++;
        }
        else{
          succpar.left=null;
        }

        if (key.compareTo(parent.data.getKey())<0) 
          parent.left.data=succ_data;        
        else
          parent.right.data=succ_data;
        
      }
    }
    return i;
   }
 
   // Does an object with this key exist? 
   public boolean contains(K key){
    int hash=(int)(Hash.djb2(key.toString(),capacity));
    KeyAndObjNode<K,T> root=Arr[hash];
    while (root!=null){
      if (key.toString().equals(root.data.getKey().toString()))
        return true;
      else if (key.compareTo(root.data.getKey())<0)
        root=root.left;
      else
        root=root.right;
    }
    return false;
   } 
 
   // Return the object with given key 
   public T get(K key) throws NotFoundException{
    int hash=(int)(Hash.djb2(key.toString(),capacity));
    KeyAndObjNode<K,T> root=Arr[hash];
    while (root!=null){
      if (key.toString().equals(root.data.getKey().toString()))
        return root.data.getObj();
      else if (key.compareTo(root.data.getKey())<0)
        root=root.left;
      else
        root=root.right;
    }
    throw new NotFoundException();
   }
 
   // ”Address” of object with given key (explained below) 
   public String address(K key) throws NotFoundException{
    int hash=(int)(Hash.djb2(key.toString(),capacity));
    String Add=Integer.toString(hash)+'-';
    KeyAndObjNode<K,T> root=Arr[hash];
    while (root!=null){
      if (key.toString().equals(root.data.getKey().toString()))
        return Add;
      else if (key.compareTo(root.data.getKey())<0){
        Add+='L';
        root=root.left;
      }
      else{
        Add+='R';
        root=root.right;
      }
    }
    throw new NotFoundException();
   }
}

