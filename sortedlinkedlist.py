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

    def delete(self, head, val) -> None:
        if head == None:
            return
        deleted = False
        sentinel = Node(-1)
        sentinel.next = head
        if head.val == val:
            sentinel.next = head.next
        else:
            while head and not deleted:
                if head.next and head.next.val == val:
                    head.next = head.next.next
                    deleted = True
                else:
                    head = head.next
        return 

    def remove_duplicates(self, head) -> None:
        if head == None:
            return
        while head:
            if head.next and head.val == head.next.val:
                while head.next and head.val == head.next.val:
                    head.next = head.next.next
                head = head.next
            else:
                head = head.next
        return

    def delete_all(self, head, val) -> None:
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
                else:
                    head = head.next
        return 

    def search(self, head, val) -> bool:
        if head == None:
            return False
        exists = False
        while head and not exists:
            if head.val == val:
                exists = True
            head = head.next
        return exists
    
    def print_list(self, head) -> None:
        if head == None:
            return
        if head:
            print(head.val)
            self.print_list(head.next)
        return




head = Node(34)
sort = SortedList()
head = sort.insert(head, 34)
head = sort.insert(head, 29)
head = sort.insert(head, 50)
head = sort.insert(head, 50)
head = sort.insert(head, 50)
head = sort.insert(head, 55)
for i in range(10):
    val = random.randint(1,100)
    head = sort.insert(head, val)
print("Values in the sorted linked list:")
sort.print_list(head)
sort.delete(head, 55)
print("Sorted list after deleting element with the value of: %2d" %(55))
sort.print_list(head)
sort.remove_duplicates(head)
print("Sorted list after deleting duplicates of element with the value of: %2d" %(50))
sort.print_list(head)
sort.delete_all(head, 34)
print("Sorted list after deleting all elements with the value of: %2d" %(34))
sort.print_list(head)
exists = sort.search(head, 29)
print("%2d is an element in the sorted array? %r" %(29, exists))


    