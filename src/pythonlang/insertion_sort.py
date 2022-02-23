def sort(input_arg, descending=False):
    current_index = 1
    while current_index < len(input_arg):
        last_sorted_index = current_index - 1
        key = input_arg[current_index]
        while last_sorted_index >= 0 and build_condition(input_arg[last_sorted_index], key, descending):
            input_arg[last_sorted_index + 1] = input_arg[last_sorted_index]
            last_sorted_index = last_sorted_index - 1
        input_arg[last_sorted_index + 1] = key
        current_index = current_index + 1
    return None


def build_condition(last_sorted_value, key, descending):
    if descending:
        return last_sorted_value < key
    else:
        return last_sorted_value > key


numbers = [2, 7, 5, 9, 2, 3, 11, 1]
print(numbers)
sort(numbers)
print(numbers)
sort(numbers, True)
print(numbers)
