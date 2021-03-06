package com.godaddy.asherah.crypto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NonceGeneratorTest {
  NonceGenerator nonceGenerator = new NonceGenerator();

  @Test
  void testCreateNonceHappyPath() {
    int numBytes = 4;
    int numBits = Byte.SIZE * numBytes;

    // Just verify we get 2 different generated byte arrays and are of expected size
    byte[] nonce1 = nonceGenerator.createNonce(numBits);
    byte[] nonce2 = nonceGenerator.createNonce(numBits);
    assertEquals(numBytes, nonce1.length);
    assertEquals(numBytes, nonce2.length);
    assertFalse(Arrays.equals(nonce1, nonce2));
  }

  @Test
  void testCreateNonceWithInvalidBitsShouldFail() {
    assertThrows(IllegalArgumentException.class, () -> nonceGenerator.createNonce(Byte.SIZE + 1));
  }

}
