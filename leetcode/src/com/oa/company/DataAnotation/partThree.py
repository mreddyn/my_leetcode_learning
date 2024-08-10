def decode(message_file):
    with open(message_file, 'r') as file:
        lines = file.readlines()

    message_words = {}

    for line in lines:
        number, word = line.strip().split()
        number = int(number)
        message_words[number] = word
    print(message_words)
    decoded_message = ''
    for i in range(1,len(message_words)):
        index = int((i*(i+1))/2)
        
        if index > len(message_words):
            break
        decoded_message = decoded_message+ ' '+ message_words[index]
        
    
    return decoded_message.lstrip()

# Test the function with an example file
decoded_message = decode('src\com\oa\company\DataAnotation\encoded_message.txt')
print(decoded_message)
