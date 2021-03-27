'''
Insertion Sort:
ALgorithm segments the list into sorted and sorted parts. It iterates 
over the unsorted segment and inserts the element being viewed into the 
correct position of the sorted list. 
Check if current element is less than previous element; 
if so keep moving all the sorted elements to the right until an element
in the sorted array is less than the current element. Replace the element after 
with the current element.
Time complexity: outer loop iterates n-1 times, inner loop, in the worst case 
scenario, keeps swapping and moving the elements to the right until place is found; O(n^2)
'''
def visualize_insertion(a):
    # first element is sorted
    for i in range(1, len(a)): 
        current = a[i]
        # index of the last element in the sorted array
        j = i-1 
        while j >=0 and a[j] > current:
            # move the larger element forward
            a[j + 1] = a[j] 
            # move backwards through the sorted array until the current is less than
            j -= 1 
            print(a) 
        # when place is found insert current, if current it greater than then keep in same place
        a[j + 1] = current
        print("Element", current, "inserted:", a)
    return 

def insertion_sort(a):
    for i in range(1, len(a)): 
        current = a[i]
        j = i-1 
        while j >=0 and a[j] > current:
            a[j + 1] = a[j] 
            j -= 1 
        a[j + 1] = current
    return 

nums = [8,5,4,10,9]
visualize_insertion(nums)
# insertion_sort(nums)
print("Final sorted list", nums)