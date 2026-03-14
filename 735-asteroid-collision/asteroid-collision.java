class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();
        for(int i : asteroids){
            
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && i < 0){
                if(Math.abs(st.peek()) < Math.abs(i) ){
                    st.pop();
                    continue;
                }
                else if(Math.abs(st.peek()) == Math.abs(i) ){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{ // Math.abs(st.peek()) > Math.abs(a)
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(i);
            }
        }

            int ans[] = new int[st.size()];

            for (int j = ans.length - 1; j >= 0; j--) { // fill array from end because stack is LIFO
             ans[j] = st.pop();                    // pop elements from stack into result array
            }
            return ans;  
        }
    }