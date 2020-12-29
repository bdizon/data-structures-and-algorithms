'''
Implementations of Bubble Sort Algorithm
'''
class BubbleSort:


    def bubble_sort(self, arr):
        num_iter = 0
        # outer loop only needs to go through len(list)-1
        for i in range(len(arr)-1):
            print("Start of " + str(i) + "-th loop")
            for j in range(len(arr)-1):
                if arr[j] > arr[j+1]:
                    arr[j], arr[j+1] = arr[j+1], arr[j]
                print(arr)
                num_iter += 1
        return arr, num_iter

    def bubble_sort2(self, arr):
        num_iter = 0
        # outer loop only needs to go through len(list)-1
        for i in range(len(arr)-1):
            print("Start of " + str(i) + "-th loop")
            # i elements are already in place bc biggest is pushed to the end 
            # for each i iteration
            for j in range(len(arr)-i-1):
                if arr[j] > arr[j+1]:
                    arr[j], arr[j+1] = arr[j+1], arr[j]
                print(arr)
                num_iter += 1
        return arr, num_iter

    def bubble_sort3(self, arr):
        num_iter = 0
        # outer loop only needs to go through len(list)-1
        for i in range(len(arr)-1):
            swap = False
            print("Start of " + str(i) + "-th loop")
            # i elements are already in place bc biggest is pushed to the end 
            # for each i iteration
            for j in range(len(arr)-i-1):
                if arr[j] > arr[j+1]:
                    arr[j], arr[j+1] = arr[j+1], arr[j]
                    swap = True
                print(arr)
                num_iter += 1
            
            #if no swaps occur then list is sorted
            if swap == False:
                break

        return arr, num_iter

arr = [1,43,2,76,46,6,0,89,23]
algo = BubbleSort()
sorted_arr, num_iter = algo.bubble_sort(arr.copy())
print("Sorted list result:", sorted_arr)
print("Number of iterations for version checking all values in array:",num_iter)
sorted_arr, num_iter = algo.bubble_sort2(arr.copy())
print("Sorted list result:", sorted_arr)
print("Number of iterations for version accounting for elements already in place:", num_iter)
sorted_arr, num_iter = algo.bubble_sort3(arr.copy())
print("Sorted list result:", sorted_arr)
print("Number of iterations for version checking if swaps occur:",num_iter)

