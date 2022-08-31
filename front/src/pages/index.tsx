import Head from 'next/head'
import type { NextPage } from 'next'
import { useState } from 'react'
import {
    AppShell,
    Header,
    Text,
    MediaQuery,
    Burger,
    useMantineTheme,
} from '@mantine/core'
import Sidebar from '../components/common/Sidebar'
import useTextColor from '../hooks/useTextColor'
import Link from 'next/link'

const Home: NextPage = () => {
    const theme = useMantineTheme()
    const [opened, setOpened] = useState(false)

    const textColor = useTextColor()

    return (
        <main>
            <Head>
                <title>Profi.rs | Fastest way to the best service</title>
                <meta
                    name="description"
                    content="Best way to get the job done when you need a specialist!"
                />
                <link rel="icon" href="/favicon.ico" />
            </Head>
            <AppShell
                styles={{
                    main: {
                        background:
                            theme.colorScheme === 'dark'
                                ? theme.colors.dark[8]
                                : theme.colors.gray[0],
                    },
                }}
                navbarOffsetBreakpoint="sm"
                asideOffsetBreakpoint="sm"
                navbar={<Sidebar opened={opened} />}
                header={
                    <Header height={70} p="md">
                        <div
                            style={{
                                display: 'flex',
                                alignItems: 'center',
                                height: '100%',
                                color: textColor,
                            }}
                        >
                            <MediaQuery
                                largerThan="sm"
                                styles={{ display: 'none' }}
                            >
                                <Burger
                                    opened={opened}
                                    onClick={() => setOpened((o) => !o)}
                                    size="sm"
                                    color={theme.colors.gray[6]}
                                    mr="xl"
                                />
                            </MediaQuery>

                            <Text weight="bold">Profi.rs</Text>
                        </div>
                    </Header>
                }
            >
                <div>
                    <Text>Resize app to see responsive navbar in action</Text>
                    <Link href="/about">About</Link>
                </div>
            </AppShell>
        </main>
    )
}

export default Home
