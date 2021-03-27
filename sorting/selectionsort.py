'''
Selection Sort:
Algorithm segments the list into two parts: sorted and unsorted. 
Continuously move the smallest element in the unsorted segment (right-segment) 
into the sorted segment (left-segment).
Time complexity: outer loop iterates n times, inner loop iterates n-1, then n-2, 
number of comparisons are (n-1) + (n-2) + ... + 1; O(n^2)
'''
def visualize_selection(a):
    for i in range(len(a)):
        # assume first element is smallest on unsorted segment
        min_val_index = i
        print("Index of start of unsorted:", min_val_index)
        for j in range(i+1, len(a)): #check the unsorted segment and ignore sorted segment for smallest val
            if a[j] < a[min_val_index]:
                min_val_index = j
                print("Index of current min value:", min_val_index)
            print("Iter i:", i, ",j:", j, ":", a )
        a[i], a[min_val_index] = a[min_val_index], a[i]
        print("Swapped:", a)

    return 

def selection_sort(a):
    for i in range(len(a)):
        min_val_index = i 
        for j in range(i+1, len(a)): 
            if a[j] < a[min_val_index]:
                min_val_index = j
        a[i], a[min_val_index] = a[min_val_index], a[i]

# nums = [3,4,7,6,5,2]
nums = [8,5,4,10,9]
visualize_selection(nums)
# selection_sort(nums)
print("Final sorted list", nums)