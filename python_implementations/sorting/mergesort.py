'''
Merge Sort is a divide and conquer algorithm that splits a list in half
and constinuously splits the list by 2 until it only has singular elements.
Sorting is done by comparing the smallest elements of each half. First 
element of each list is compared first. The first half of the lsit begins 
with a smaller value, then add that to the sorted list. The compare the
second smallest value of the first half with the first smallest value of
the second half. Everytime a smaller valut at beginning of a hlaf is selected
we move the nidex of which item needs to be compared by 1. 
Time Complexity: merge function takes two lists and iterates through it n times
where n is the size of the combined lists. Merge_sort functions splits the given 
array into two recursively, similar to a binary tree, so it grows logsrithmically to n;
O(nlog(n)).
'''
def visualize_merge(left_list, right_list):
    sorted_list = []
    left_index = right_index = 0
    left_length, right_length = len(left_list), len(right_list)

    # length of the whole list
    for _ in range(left_length + right_length):
        if left_index < left_length and right_index < right_length:
            # check if the value at the srat of each list is smaller
            # if item at beginning of the left list, add it to sorted_list
            if left_list[left_index] <= right_list[right_index]:
                sorted_list.append(left_list[left_index])
                left_index += 1
            # if the item at beginning of the right list is smaller then
            # add it to the sorted_list
            else:
                sorted_list.append(right_list[right_index])
                right_index += 1

        # if we reached the end of left_list ten add elements from the right list
        elif left_index == left_length:
            sorted_list.append(right_list[right_index])
            right_index += 1
        # if we reached the end of left_list ten add elements from the right list
        elif right_index == right_length:
            sorted_list.append(left_list[left_index])
            left_index += 1
    
    print("Current sorted list:", sorted_list)
    return sorted_list

def visualize_merge_sort(a):
    # catch and return when list is a sinle element or empty
    if len(a) <= 1:
        return a

    # floor division to get midpoint
    mid = len(a) // 2

    # sort and merge each half
    left_list = visualize_merge_sort(a[:mid])
    print("Left split:", left_list)
    right_list = visualize_merge_sort(a[mid:])
    print("Right split:", right_list)

    # merge the sorted lists into a new one
    return visualize_merge(left_list, right_list)

def merge(left_list, right_list):
    sorted_list = []
    left_index = right_index = 0
    left_length, right_length = len(left_list), len(right_list)

    for _ in range(left_length + right_length):
        if left_index < left_length and right_index < right_length:
            if left_list[left_index] <= right_list[right_index]:
                sorted_list.append(left_list[left_index])
                left_index += 1
            else:
                sorted_list.append(right_list[right_index])
                right_index += 1

        elif left_index == left_length:
            sorted_list.append(right_list[right_index])
            right_index += 1
        elif right_index == right_length:
            sorted_list.append(left_list[left_index])
            left_index += 1
    
    return sorted_list

def merge_sort(a):
    if len(a) <= 1:
        return a

    mid = len(a) // 2

    left_list = merge_sort(a[:mid])
    right_list = merge_sort(a[mid:])

    return merge(left_list, right_list)

nums = [8,5,4,10,9,45,1,354,23,139]
print("Unsorted list:", nums)
nums = visualize_merge_sort(nums)
# nums = merge_sort(nums)
print("Final sorted list", nums)