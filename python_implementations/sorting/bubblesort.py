'''
Bubble Sort:
Iterates over a list and copares elements in pairs 
swaps them until the larger elements bubble up to the end 
of the list and the smaller elemenrs stay at the bottom.
Time complexity: worst case scenario need to swap every single item in array; 
O(n^2).
'''
def visualize_bubble(a):
    swapped = True 
    while swapped:
        swapped = False # if false after for loop then no elements were swapped, list is sorted
        for i in range(len(a)-1):
            if a[i] > a[i+1]:
                a[i], a[i+1] = a[i+1], a[i]
                swapped = True # something was still out of order
            print("Iter", i, ":", a )
            # print(a)
    return 

def bubble_sort(a):
    swapped = True 
    while swapped:
        swapped = False 
        for i in range(len(a)-1):
            if a[i] > a[i+1]:
                a[i], a[i+1] = a[i+1], a[i]
                swapped = True 
    return 

nums = [8,5,4,10,9]
visualize_bubble(nums)
# bubble_sort(nums)
print("Final sorted list", nums)