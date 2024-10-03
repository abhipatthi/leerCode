def find_pair(input_array, sum_to_find):
    my_set = set()

    for num in input_array:
        difference = sum_to_find - num

        if difference in my_set:
            print(f"{num},{difference}")

        my_set.add(num)

if __name__ == "__main__":
    input_array = [10, 15, 3, 7, 25]
    sum_to_find = 13

    find_pair(input_array, sum_to_find)
