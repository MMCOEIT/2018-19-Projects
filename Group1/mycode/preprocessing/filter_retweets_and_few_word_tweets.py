"""
code to read author's tweets andremove retweets and tweets with less words.
The output will be stored in seperate directory
"""

import argparse


def command_line_parsing():
   parser=argparse.ArgumentParser()  #create an argument parser

   #Adding Positional & Optional Arguments
   parser.add_argument('--source-dir-data','-s',
                       dest='source_dir_data',
                       required=True,
                       help='Directory where the tweet files are stored.')

   parser.add_argument('--dest-dir','-d',
                       dest='dest_dir',
                       required=True,
                       help='Directory where output will be stored.')

   parser.add_argument('--filter-retweets','-f',
                       dest='filter_retweets',
                       action='store_true',
                       default=False,
                       help='filter out retweets i.e tweets that contain RT as meta tag')

   parser.add_argument('--minimal-number-words','-m',
                        dest='min_words',
                        type=int,
                        default=3,
                        help='Minimum no of words required to keep the tweet,otherwise filter out them if less than 3')

   parser.add_argument('--debug','-e',
                        action='store_true',
                        default=False,
                        help='print debbug info')

   return parser.parse_args()

if __name__ == '__main__':
    #parsing arguments
    args=command_line_parsing()
   
    
    
