import React from 'react';
import { ScrollView } from 'react-native';
import { Box } from '@/components/ui/box';
import { Text } from '@/components/ui/text';
import { Button, ButtonText, ButtonIcon } from '@/components/ui/button';
import { HStack } from '@/components/ui/hstack';
import { VStack } from '@/components/ui/vstack';
import { AddIcon } from '@/components/ui/icon';

export default function HomeScreen() {
  return (
    <ScrollView className="bg-slate-50">
      <Box className="p-6 pt-12 bg-green-600 rounded-b-3xl shadow-lg">
        <VStack space="xs">
          <Text className="text-white opacity-80 text-sm font-medium">Total Balance</Text>
          <Text className="text-white text-4xl font-bold">₹24,500.00</Text>
        </VStack>
        
        <HStack className="mt-6 justify-between items-center bg-white/20 p-4 rounded-2xl">
          <VStack>
            <Text className="text-white/70 text-xs">Income</Text>
            <Text className="text-white font-semibold">₹30,000</Text>
          </VStack>
          <Box className="w-[1px] h-8 bg-white/30" />
          <VStack>
            <Text className="text-white/70 text-xs">Expenses</Text>
            <Text className="text-white font-semibold">₹5,500</Text>
          </VStack>
        </HStack>
      </Box>

      <Box className="p-6">
        <HStack className="justify-between items-center mb-4">
          <Text className="text-xl font-bold text-slate-800">Recent Transactions</Text>
          <Button variant="link" size="sm">
            <ButtonText className="text-green-600">See All</ButtonText>
          </Button>
        </HStack>

        {/* Example Transaction Item */}
        <VStack space="md">
          <TransactionItem title="Grocery" category="Food" amount="-₹1,200" color="bg-orange-100" />
          <TransactionItem title="Freelance" category="Work" amount="+₹5,000" color="bg-blue-100" />
          <TransactionItem title="Netflix" category="Ent." amount="-₹499" color="bg-purple-100" />
        </VStack>

        <Button 
          size="lg" 
          className="mt-8 bg-green-600 rounded-2xl shadow-md h-16"
          onPress={() => console.log('Add Expense')}
        >
          <ButtonIcon as={AddIcon} className="mr-2" />
          <ButtonText className="font-bold text-lg">Add New Expense</ButtonText>
        </Button>
      </Box>
    </ScrollView>
  );
}

// A simple helper component for your list
function TransactionItem({ title, category, amount, color }: any) {
  return (
    <HStack className="bg-white p-4 rounded-2xl items-center justify-between shadow-sm">
      <HStack space="md" className="items-center">
        <Box className={`w-12 h-12 rounded-full ${color} items-center justify-center`} />
        <VStack>
          <Text className="font-bold text-slate-800">{title}</Text>
          <Text className="text-xs text-slate-500">{category}</Text>
        </VStack>
      </HStack>
      <Text className={`font-bold ${amount.startsWith('+') ? 'text-green-600' : 'text-red-500'}`}>
        {amount}
      </Text>
    </HStack>
  );
}