class BubbleSort {
  static void main(String... args) {
    if(!validateInput(args)) {
      println 'Usage: please provide a list of at least two integers to sort in the format "1, 2, 3, 4, 5"'
    } else {
      List numbers = parseInput(args[0])
      sort(numbers)
      println formatOutput(numbers)
    }
  }

  static private Boolean validateInput(String... input) {
    return input.length >= 1 &&
      input[0] ==~ /(\d+,\s)+\d/
  }

  static private List parseInput(String inputString) {
    return inputString.tokenize(', ').collect {it.toInteger()}
  }

  static private String formatOutput(List numbers) {
    return numbers.join(', ')
  }

  static private void sort(List numbers) {
    Boolean swapOccured = true
    Integer number1, number2
    while(swapOccured) {
      swapOccured = false
      for(int i = 0; i < numbers.size() - 1; i++) {
        number1 = numbers[i]
        number2 = numbers[i + 1]
        if(number1 > number2) {
          swapWithNext(numbers, i)
          swapOccured = true
        }
      }
    }
  }

  static private void swapWithNext(List numbers, int index) {
    Integer temp = numbers[index]
    numbers[index] = numbers[index + 1]
    numbers[index + 1] = temp
  }
}
