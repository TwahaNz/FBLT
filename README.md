# FBLT

##Basic overview

We intend on creating an app which will serve as a platform for people in all types of

communities but mainly for those in rural communities to post as well as view adverts and

be able to sell their products/services. Users will be able to post adverts of them either

looking to buy or sell items.

##Domain Diagram

![Domain Model](/ERD.png)

##How is this unique?

When reading through the overview you might think that there are many apps already out

there which already cater to this market, namely Gumtree, Takealot etc. However our app

would differ in terms of target market and various features which will be discussed later in

the spec.

The different market to which we are referring to would be the people in rural communities

in Africa (But for now South Africa), there is a gap in the market for a platform on which

they can buy and sell items that are more relevant to their lifestyle such as livestock.

##Features

Our focus with the app’s features is to create an easy to use, uncomplicated app which

provides optimum user experience. We will strive to make this app seamless from a user’s

perspective.

##Easy registration

The user will not be required to go through a lengthy registration process which demands a

large amount of unnecessary information, rather we will only require the bare minimum

ensuring that the app is easy and straight forward to use.

No passwords

With the increasing amount of apps each user has it becomes a burden to remember all of

these passwords therefore we intend on doing away with this feature by implementing a

“one time” login feature

##Ratings

Each registered user will have a rating associated with their profile. This rating will either

increase or decrease depending on how reliable their previous adverts have been. For

example if person A buys something from person B, person A will then be able to rate

person A depending on criteria such as reliability and quality of product. Person A will only

allowed to do this once. This will be done to avoid inconsistency or abuse of the rating

policy.

##Dynamic user location

When a user is posting an advert they should not have to manually insert their location, our

app should be able to find their location and suggest it, the user can then choose to accept

or fill it out manually. The meet up location when buying/selling should also be suggested,

perhaps suggest any public and safe environment within a 5km radius such as a police

station. Again, the user can manually change this, our app will just give them a suggestion.

##Telegram

Users will need a platform on which they can interact with one another when interested in a

product or service and should be able to do so in a easy and secure manner.

A solution brought forward, is to use a messaging service called Telegram.

Telegram is a cloud based messaging/chat app, that works on iPhone, Android and

Computers (through a web interface), and allows users to be logged in on more than 1

device at once, with seamless syncing.

Telegram also allows for the use of a username when chatting, this feature safeguards users

from having their phone number revealed to the other participant in the conversation.

##Algorithm to detect category

Most sites that have a similar concept to ours force you to choose a category when posting

an advert, this further complicates the process of posting an advert, as often there are too

many categories to scroll through and your advert may fall under multiple or no categories at all.

With our app you will not be required to choose a category as we will create an algorithm

which can detect what category your advert falls under with just the information you

provided when posting the advert. Again the user will be allowed to choose or add a

category if it does not exist. All created categories by users will have to get approved by the

administrators of the website.
