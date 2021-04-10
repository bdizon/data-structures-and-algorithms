'''
Heap: min heap or max heap
Max Heap: root node is greater than or equal to either of its children.
Min Heap: root node is less than or equal to either of its children.
Heap Sort separates the list into a sorted sorted and unsorted segment.
First transform the list into a max heap using a heapify function. Remove 
the root of that tree and place at the end of the list because it is the max
value. Then rebuild the max heap, which has now one less element, placing the 
new max value before the last item of the list. Iterate until all nodes
are removed.
Time Complexity: heapify function traverses tree structure in O(log(n)) time.
Heap sort function iterates over the array n times; 
O(nlog(n)).
'''

def visualize_heapify(a, heap_size, root_index):
    # assume index of largest is the root index
    largest = root_index
    print("Current index:", largest)
    print("Current heap:", a)
    left_child = (2 * root_index) + 1
    right_child = (2 * root_index) + 2

    # check for valid index 
    # if left child is greater than lergest element, update largest element
    if left_child < heap_size and a[left_child] > a[largest]:
        largest = left_child
    
    # check for valid index 
    # if left child is greater than lergest element, update largest element
    if right_child < heap_size and a[right_child] > a[largest]:
        largest = right_child

    # if root element isnt the largest element then swap root with largest
    if largest != root_index:
        a[root_index], a[largest] = a[largest], a[root_index]
        print("Swapped:", a)
        # heapify/ search further down the rest of the tree to make sure its largest
        visualize_heapify(a, heap_size, largest)
    print("End of Recursion")
    return


def visualize_heap(a):
    size = len(a)
    # create max heap
    # 2nd arg stops before -1 
    # 3rd arg means iterate backwards
    for i in range(size, -1, -1):
        visualize_heapify(a, size, i)
    print("Max heap created\n")
    # move the root of the max heap to the end of the unsorted segment of the list
    # start from the end of the list, subtract one because its the index
    for i in range(size - 1, 0, -1):
        # first element always is the max of the remaining list
        a[i], a[0] = a[0], a[i]
        # heapify bc heap is no longer a max heap
        visualize_heapify(a, i, 0)

    return 

def heapify(a, heap_size, root_index):
    largest = root_index
    left_child = (2 * root_index) + 1
    right_child = (2 * root_index) + 2

    if left_child < heap_size and a[left_child] > a[largest]:
        largest = left_child
    
    if right_child < heap_size and a[right_child] > a[largest]:
        largest = right_child

    if largest != root_index:
        a[root_index], a[largest] = a[largest], a[root_index]
        heapify(a, heap_size, largest)
    return

def heap_sort(a):
    size = len(a)
    
    for i in range(size, -1, -1):
        heapify(a, size, i)

    for i in range(size - 1, 0, -1):
        a[i], a[0] = a[0], a[i]
        heapify(a, i, 0)
    return 

nums = [8,5,4,10,9]
# visualize_heap(nums)
heap_sort(nums)
print("Final sorted list", nums)