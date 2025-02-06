
#   [1,2,3]

petumutations are nothing but the possible combinations of this numbers .
# Logic : 
## step 1 = travers the array from right until we get i th idex which is greater than its just previous index.i.e. arr[i-1] < arr[i] .
## step 2 = select that i-1 index as gola_idx.
## step 3 = travers the arr again from right til we get arr[i] > selected index .
## step 4 = select that index as swap_idx.
## step 5 = swap the elements of both the indexes .
## step 6 = form gola+1 index to end of arr reverse the array .
## step 7 = finally we get the next permutation .