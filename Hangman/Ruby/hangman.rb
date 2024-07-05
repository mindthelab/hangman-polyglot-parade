class Game
    def initialize(word = "banana")
        @word = word
        @len = @word.length
        @life = 5
        @game = true
        @guess = nil
        @table = Array.new(@len, "_")
    end

    def start_game
        puts "The secret word has #{@len} letters! You only have #{@life} lives!"
        while @game
            print @table.join(" ")
            print " Your Guess: "
            check_guess
            check_result
        end
    end

    def check_guess
        @guess = gets.chomp
        found = false

        for i in 0...@len
            if @guess == @word[i]
                @table[i] = @guess
                found = true
            end
        end

        unless found
            @life -= 1
            puts "Wrong!"
            puts "You have #{@life} guesses remaining"
            if @life == 0
                @game = false
                puts "You lost! The secret word is #{@word}"
            end
        end
    end

    def check_result
        unless @table.include?("_")
            @game = false
            puts "You won with #{@life} lives remaining!"
            puts "The word was #{@word}"
        end
    end
end

# ruby is so fun

game = Game.new
game.start_game
