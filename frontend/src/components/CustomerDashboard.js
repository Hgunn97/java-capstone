import { Center, Container, Heading, VStack, Text } from '@chakra-ui/react';
import Logout from './Logout';

function CustomerDashboard() {
    let user = sessionStorage.getItem('user');
    return (
        <Container>
            <Center p={4} minHeight='70vh'>
                <VStack>
                    <Container maxW='container.md' textAlign='center'>
                        <Heading>Welcome {user}</Heading>
                        <Text>This is your customer dashboard</Text>
                        <Logout />
                    </Container>
                </VStack>
            </Center>
        </Container>
    );
}

export default CustomerDashboard;
