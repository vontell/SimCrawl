

graph = {
	'Dining':set(('Late Night',48)),
	'Late Night':set(('Dining',48),('Mailbox',48)),
	'Mailbox':set(('Entrance',48),('MPR',24)),
	'Entrance':set(('Mailbox',48),('MPR',69),('2C',48)),

	'2C':set(('Entrance',48),('2B',148),('3C',48)),
	'2B':set(('Essigmans\'',48),('2A',148),('3B',48),('2C',148)),
	'Essigmans\'':set(('2B',48)),
	'2A':set(('Party Room',62),('2B',148),('3A',48)),
	'Party Room':set(('2A',62)),

	'3A':set(('2A',48),('4A',48),('3B',148)),
	'3B':set(('2B',48),('4B',48),('3A',148)),
	'3C':set(('2C',48),('4C',48)),

	'4A':set(('3A',48),('5A',48),('4B',148)),
	'4B':set(('3B',48),('5B',48),('4A',148)),
	'4C':set(('3C',48),('5C',48)),

	'5A':set(('4A',48),('6A',48),('5B',148)),
	'5B':set(('4B',48),('5A',148),('5C',148)),
	'5C':set(('4C',48),('6C',48),('5B',148)),

	'6A':set(('5A',48),('7A',48),('6B',148)),
	'6B':set(('6B Lounge',41),('6A',148),('6C',148)),
	'6C':set(('6B',148),('7C',148)),
	'6B Lounge':set(('6B',41),('7B',48)),

	'7A':set(('6A',48),('7B',148),('8A',48)),
	'7B':set(('6B Lounge',48),('7A',148),('7C',148),('8B',48))
	'7C':set(('7B',148),('8C',48),('6C',48)),

	'8A':set(('7A',48),('9A',48)),
	'8B':set(('7B',48),('9B',48)),
	'8C':set(('7C',48),('9C',48)),

	'9A':set(('8A',48),('10A',48)),
	'9B':set(('8B',48),('10B',48)),
	'9C':set(('8C',48),('10C',48)),

	'10A':set(('9A',48)),
	'10B':set(('9B',48)),
	'10C':set(('9C',48))
}
