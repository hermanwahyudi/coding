require 'time'

puts File.read(ARGV[0]).gsub(/^(.*) --> (.*)$/){[
$1,$2].map{|x|(t=Time.parse(x.strip)+ARGV[1].to_f
).strftime("%H:%M:%S,#{t.usec}00")[0,12]}*' --> '}

