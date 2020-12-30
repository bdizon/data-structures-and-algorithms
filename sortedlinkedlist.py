'''
 Implementation of Sorted Linked List
'''
import random

class Node():
    def __init__(self, val):
        self.val = val
        self.next = None

class SortedList:
    def insert(self, head, val) -> Node:
        if head == None:
            return Node(val)
  
        new = Node(val)
        sentinel = Node(-1)
        sentinel.next = head
        curr = head
        inserted = False
        if val < head.val:
            new.next = head
            sentinel.next = new
        else:
            while curr and not inserted:
                # keep moving through list if element is greater than
                # look at value after the current node to be able to insert node inbetween
                if curr.next and val > curr.next.val:
                    curr = curr.next
                else:
                    new.next = curr.next
                    curr.next = new
                    inserted = True

        return sentinel.next

    def delete(self, head, val) -> Node:
        if head == None:
            return 
        sentinel = Node(-1)
        sentinel.next = head
        if head.val == val:
            sentinel.next = head.next
        else:
            while head:
                if head.next and head.next.val == val:
                    head.next = head.next.next
                    # head = head.next
                else:
                    head = head.next
        return sentinel.next

    def search(self, head, val) -> Node:
        return
    
    def print_list(self, head) -> None:
        if head == None:
            return
        if head:
            print(head.val)
            self.print_list(head.next)
        return

    def removeDuplicates(self, head) -> Node:
        return



head = Node(34)
sort = SortedList()
head = sort.insert(head, 34)
for i in range(10):
    val = random.randint(1,100)
    head = sort.insert(head, val)
print("Values in the Sorted Linked List:")
sort.print_list(head)
sort.delete(head, 34)
print("Sorted list after deleting: %2d" %(34))
sort.print_list(head)


    