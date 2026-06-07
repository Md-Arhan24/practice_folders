/*
 * classical trap
 * Ah, Arhan — this is a **classic Java mutability trap** that bites even experienced devs. The difference between these two versions hinges on **how Java handles `String` references and reassignment**. Let’s break it down step by step.

---

### 🔍 The Core Difference

#### ✅ Version 1 (Correct):
```java
printSubsets(str, i+1, str2 + str.charAt(i));
printSubsets(str, i+1, str2);
```
- `str2 + str.charAt(i)` creates a **new String object**.
- `str2` remains **unchanged** for the second recursive call.
- So, each recursive path explores:
  - One with the character included.
  - One without the character.

#### ❌ Version 2 (Buggy):
```java
printSubsets(str, i+1, str2 += str.charAt(i));
printSubsets(str, i+1, str2);
```
- `str2 += str.charAt(i)` is **syntactic sugar** for:
  ```java
  str2 = str2 + str.charAt(i);
  ```
- This **modifies the reference `str2`** before the first recursive call.
- So by the time you reach the second call, `str2` is already changed!

---


 */
public class PrintSubSets {
    public static void printSubsets(String str,int i,String str2){
        if(i == str.length()){
            System.out.println(str2);
            return;
        }
        //every char has two choices to come and not come
        printSubsets(str,i+1,str2+str.charAt(i));
        printSubsets(str, i+1, str2);
    }
    public static void main(String[] args) {
        //total subsets of length n will be 2^n include empty set
        String str = "abc";
        printSubsets(str,0,"");
    }
}
